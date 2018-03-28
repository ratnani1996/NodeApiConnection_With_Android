const router = require('express').Router();
const {studentModel} = require('../model/studentModel')

//get all the student data from the database
//ideally use it at the main homepage to get and show all the data
router.get('/', (req, res)=>{
    studentModel.find()
                .then((students)=>{
                    res.json(students)
                })
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))

})


//post the data to the server
// the data to be send from the client side should be like this
/*
    {
        "name" : "Abhishek",
        "roll" : 6,
        "percentage" : 88.40,
        "schoolName" : "XYZ school"
    }
*/
router.post('/data/input', (req, res)=>{
    var student = new studentModel({
        name : req.body.name,
        roll : req.body.roll,
        percentage : req.body.percentage,
        schoolName : req.body.schoolName
    })
    
    student.save()
           .then((student)=>{
               res.redirect('/')
           })
           .catch((err)=>{
               res.status(404).json({msg : "Something went wrong" })
           })
})


//perform a DELETE request and perform a delete operation
//the request should be to the route '/data/delte/1234567890'
//where '1234567890' is the id of the user whose data should be delted
router.delete('/data/delete/:id', (req, res)=>{
    studentModel.findByIdAndRemove(req.params.id)
                .then((student)=> res.redirect('/'))
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))
})


//perform a PUT request and update the data of the user
//and the request should be to the route '/data/put/1234567890'
//where '1234567890' is the user id of the user whose data should be updated
//then send the updated data again to update it at the database
/*
data to be sent should be of the syntax
    {
        "name" : "Abhishek",
        "roll" : 6,
        "percentage" : 88.40,
        "schoolName" : "XYZ school"
    }
*/
router.put('/data/put/:id', (req, res)=>{
    var student = {
        name : req.body.name,
        roll : req.body.roll,
        percentage : req.body.percentage,
        schoolName : req.body.schoolName
    }
    studentModel.findByIdAndUpdate({_id : req.params.id}, {
        $set : student
    })
    .then((student)=> res.redirect('/'))
    .catch((err)=> res.status(404).json({msg : "Something went wrong"}))
})


//perform a GET request to get the data of individual user
//request should be of the king '/data/find/1234567890'
//where '1234567890' is the user id of the user whose individual data is to be viewed
router.get('/data/find/:id', (req, res)=>{
    studentModel.findById(id)
                .then((student)=> res.json(student))
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))            
})

module.exports = router;