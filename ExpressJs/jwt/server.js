const express = require('express')

const app = express()

const jwt = require('jsonwebtoken')

app.use(express.json())

const posts = [
    {
        "username": "China",
        "title": "Harrrrrr"
    },
    {
        "username": "Srun",
        "title": "Life"
    },
]


app.get('/posts', (req, res) => {
    res.send(posts)
})


app.post('/login', (req, res) => {
    // Authenticate the user

    const username = req.body.username;
})

app.listen(3000)