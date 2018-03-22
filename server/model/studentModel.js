const mongoose = require('mongoose')

const studentSchema = new mongoose.Schema({
    name : {
        type : String
    },
    roll : {
        type : Number
    },
    percentage : {
        type : Number
    },
    schoolName : {
        type : String
    }
})

const studentModel = mongoose.model('students', studentSchema);

module.exports = {studentModel};