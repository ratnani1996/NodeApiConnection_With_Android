const express = require('express')
const app = express();
//requiring bodyParser
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

//create mongooDb connection
const mongoose = require('mongoose')
mongoose.Promise = global.Promise;
var url = `mongodb://localhost:27017/android`
const conn = mongoose.createConnection(url)
conn.once('connected', ()=> console.log(`Connection to the database up and runnning`))
conn.on('err', (err)=> console.log(err))





app.listen(3000, ()=> console.log(`Running on localhost 3000`))