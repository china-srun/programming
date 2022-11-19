const { Router } = require('express');

const router = Router()

groceryList = [
    {
        item: 'milk',
        quantity: 1
    },
    {
        item: 'orange',
        quantity: 6
    },
    {
        item: 'cereal',
        quantity: 1
    },
]


router.get('/', 
// response can be called only once since we send only one request
    (req, res, next) => {
        console.log("Before handling the request");
        next()
    },
    (req, res, next) => {
        res.cookie("visited", true, {
            maxAge: 10000
        })
        res.send(groceryList);
        next()
    }, 
    () => {
        console.log("Finished executing GET request");
    }
)

router.get('/:item', (req, res) => {
    const {item} = req.params;
    const groceryItem = groceryList.find((g) => g.item === item)
    res.send(groceryItem)
}) 


router.post('/', (req, res) => {
    console.log(req.body)
    groceryList.push(req.body)
    res.send(201)
})

module.exports = router