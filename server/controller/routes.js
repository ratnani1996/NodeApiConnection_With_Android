const router = require('express').Router();
const {studentModel} = require('../model/studentModel')
router.get('/', (req, res)=>{
    studentModel.find()
                .then((students)=>{
                    res.json(students)
                })
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))

})

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

router.delete('/data/delete/:id', (req, res)=>{
    studentModel.findByIdAndRemove(req.params.id)
                .then((student)=> res.redirect('/'))
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))
})

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

router.get('/data/find/:id', (req, res)=>{
    studentModel.findById(id)
                .then((student)=> res.json(student))
                .catch((err)=> res.status(404).json({msg : "Something went wrong"}))            
})

module.exports = router;