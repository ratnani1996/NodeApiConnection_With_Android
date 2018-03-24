const router = require('express').Router();
const {studentModel} = require('../model/studentModel')
router.get('/', (req, res)=>{
    studentModel.find()
                .then((students)=>{
                    res.json(students)
                })
                .catch((err)=>{
                    res.json(err);
                })
})

router.post('/data/input', (req, res)=>{
    var student = new studentModel({
        name : req.body.name,
        roll : req.body.roll,
        percentage : req.body.percentage,
        schoolName : req.body.shcoolName
    })
    
    student.save()
           .then((student)=>{
               res.redirect('/')
           })
           .catch((err)=>{
               res.status(404).json({msg : "Something went wrong" })
           })
})

module.exports = router;