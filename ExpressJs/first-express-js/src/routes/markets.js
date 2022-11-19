const { Router } = require('express');

const router = Router()


supermarkets = [
    {
        id: 1,
        store: "store1",
        miles: 1.4
    },
    {
        id: 2,
        store: "store2",
        miles: 0.2
    },
    {
        id: 3,
        store: "store3",
        miles: 4.5
    },
    {
        id: 4,
        store: "store4",
        miles: 3.5
    },
    {
        id: 5,
        store: "store5",
        miles: 0.7
    },
]

router.get('/', (req, res) => {
    const { miles } = req.query;
    const parsedMiles = parseInt(miles)
    if (!isNaN(parsedMiles)) {
        const filteredStores = supermarkets.filter(store => store.miles <= parsedMiles)
        res.send(filteredStores)
    }
    else {
        res.send(supermarkets)
    }
})


module.exports = router