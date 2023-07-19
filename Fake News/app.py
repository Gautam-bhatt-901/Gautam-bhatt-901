import requests
from bs4 import BeautifulSoup
import numpy as np
import pickle
from flask import Flask, request, render_template
from sklearn.feature_extraction.text import TfidfVectorizer


app = Flask(__name__)
model = pickle.load(open('model.pkl', 'rb'))
tfidfvect = pickle.load(open('vector.pkl', 'rb'))


@app.route('/')
def home():
    return render_template('projectweb.html')


@app.route('/predict', methods = ['POST'])
def predict():
    user_input = request.form.get('url')
    check_data = title_fetch_vector(user_input)
    prediction = model.predict(check_data)
    output = "Fake" if prediction == 1 else "Real"
    return render_template('projectweb.html',prediction_text=f"The News is {output}")


# This function will fetch the title of the news article and convert them into numerical data
def title_fetch_vector(url):
    req = requests.get(url)
    htmlContent = req.content
    soup = BeautifulSoup(htmlContent,"html.parser")
    article_title = soup.find('h1').get_text() 
    title_list = [article_title]
    title_arr = np.array(title_list)
    Y = tfidfvect.transform(title_arr)
    return Y


if __name__ ==  "__main__":
    app.run(debug=True)