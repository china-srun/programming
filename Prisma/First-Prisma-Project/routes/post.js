const router = require('express').Router();
const {PrismaClient} = require('@prisma/client');

const { user, post } = new PrismaClient();

router.post('/', async (req, res) => {
    const { p_title, user_id} = req.body;

    const userExists = await user.findUnique({
        where: { 
            id: user_id
        },
    });

    if (!userExists) {
        return res.status(400).json({ 
            msg: "Cannot post since user does not exist!"
        })
    }

    else {
        const newPost = await post.create({
            data: {
                p_title,
                user_id
            }
        });

        res.json(newPost);
    }
})

router.get('/:user_id', async (req, res) => {
    const { user_id } = req.params;
    const posts = await post.findMany({
        where: {
            user_id: user_id
        },
        select: {
            p_id: true,
            p_title: true,
            created_at: true,
            user_id: true,
        }
    })

    res.send(posts);
})

module.exports = router