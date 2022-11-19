const express = require('express');
const cookieParser = require('cookie-parser');
const groceriesRoute = require('./routes/groceries')
const marketsRoute = require('./routes/markets')

const app = express();  
const PORT = 3001;

// middleware (convert body to json)
app.use(express.json());
// identify the data when parse in urlencoded
app.use(express.urlencoded());
app.use(cookieParser())


app.use('/api/v1/groceries', groceriesRoute)
app.use('/api/v1/markets', marketsRoute)



app.listen(PORT, () => {
    console.log('running server on port ' + PORT);
});

