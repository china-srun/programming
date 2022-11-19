const express = require('express');
const bodyparser = require('body-parser');
const cors = require('cors');
const mysql = require('mysql2');

const app = express();
app.use(cors());
app.use(bodyparser.json());

// database connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    port: '3307',
    password: 'Ch086747569',
    database : 'bookdb',
});

let qr = `select * from allbooks`
db.query(qr, (err, result)=>{
    console.log(result)
})


// check database connection
db.connect(err=>{
    if (err) {console.log(err, "dberr")}
    else {
        console.log('database connected ...')
    }
})

// get all data
app.get('/allbooks', (req,res)=>{
        let qr = `select * from allbooks`;
        db.query(qr, (err, result)=>{
                if(err){
                    console.log(err, 'errs');
                }
                if (result.length>0){
                    res.send({
                        message: 'all books data',
                        data: result
                    })
                }
                else {
                    res.send({
                        message: 'no data is exist in the database'
                    })
                }
        });
})


// get single data
app.get('/allbooks/:id', (req, res) => {
        let getID = req.params.id;
        let qr = `select * from allbooks where id = ${getID}`;
        db.query(qr, (err, result)=>{
            if (err) {
                console.log(err);
            }
            if (result.length>0){
                res.send({
                    message: 'get single data',
                    data: result
                })
            }
            else{
                res.send({
                    message: 'data not found',

                })
            }
        })
})

// create data
app.post('/allbooks', (req, res) => {
        console.log(req.body, 'createdata');

        let id = req.body.id;
        let title = req.body.title;
        let description = req.body.description;
        let author = req.body.author;
        let category = req.body.category;
        let completed = req.body.completed;
        console.log(req.body.id)
        let qr = `insert into allbooks(id, title, description, author, category, completed) 
                    values('${id}', '${title}', '${description}', '${author}', '${category}', '${completed}');`;

        let check = `select * from allbooks where id = ${id}`;
        db.query(check, (err, result) => {
                if (err){
                        console.log(err);
                }
                
                
                if (result.length != 0){
                    res.send({
                        message: 'duplicated data'
                    })
                }
                else {
                    db.query(qr, (err, result) => {
                        if (err){
                            console.log(err);
                            
                        }
                        console.log(result, 'result');
                        res.send({
                            message: 'data inserted',
                        })
                    })
                }
        })
})      

// update single data
app.put('/allbooks/:id', (req, res) => {
    console.log(req.body, 'updatedata');

    let getID = req.params.id;

    let title = req.body.title;
    let description = req.body.description;
    let author = req.body.author;
    let category = req.body.category;
    let completed = req.body.completed;

    
    let qr = `update allbooks set title = '${title}', description = '${description}', author = '${author}', category = '${category}', completed = '${completed}' where id = ${getID}`;

    db.query(qr, (err, result) => {
        if (err){
            console.log(err);
        }
        else {
            res.send({
                message: 'data updated'
            })
        }
    })
})



// delete
app.delete('/allbooks/:id', (req, res)=>{
    let getID = req.params.id;
        let qr = `select * from allbooks where id = ${getID}`;
        db.query(qr, (err, result)=>{
            if (err) {
                console.log(err);
            }
            if (result.length==0){
                res.send({
                    message: 'data not found',
                })
            }
            else{
                qr = `delete from allbooks where id = ${getID}`
                db.query(qr, (err, result)=>{
                    if (err){console.log(err)}
                    res.send({
                        message: 'data deleted',
                    })
                })
            }
        })
})

// patch
app.patch('/allbooks/:id', (req, res) => {
    // if (req.params.id * 1 > allbooks.length) {
    //     return res.status(404).json({
    //         status: 'fail',
    //         message: 'invalid id'
    //     })
    // }

    // res.status(200).json({
    //     status: 'success',
    //     data: {
    //     }
    // })
})


app.listen(3000, ()=> {
    console.log('server running');
})