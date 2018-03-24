const express = require('express')
const app = express();

//create mongooDb connection
const mongoose = require('mongoose')
mongoose.Promise = global.Promise;
var url = `mongodb://localhost:27017/android`
mongoose.connect(url)
mongoose.connection
        .once('connected', ()=> console.log(`Connection to the database up and running`))
        .on('err', (err)=> console.log(err))

//requiring bodyParser
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())


//acquire routes
app.use(require('./controller/routes'))

app.use((req, res)=> res.status(404).json({msg : "Something Went wrong"}))

app.listen(3000, ()=> console.log(`Running on localhost 3000`))