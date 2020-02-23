db.auth('root', 'example');
db = db.getSiblingDB('recommendation');
const username = "recommender";
const password = "recommender";
db.createUser(
    {
        user: username,
        pwd: password,
        roles: [
            { role: "readWrite", db: "recommendation" }
        ]
    });