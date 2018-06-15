# Mock REST requests for testing

Find details about this project [here](https://github.com/typicode/json-server).

Sample data is generated using this template
```
[
  '{{repeat(5, 7)}}',
  {
    movieId: '{{objectId()}}',
    title: '{{lorem(1, "words")}}',
    description: '{{lorem(1, "paragraphs")}}',
    rating: '{{bool()}}',
    price: '{{floating(1000, 4000, 2, "$0,0.00")}}',
    image: 'http://placehold.it/32x32'
  }
]

```

npm install -g json-server

[Generate testing json data](https://www.json-generator.com/)

json-server --port 3333 --watch db.json