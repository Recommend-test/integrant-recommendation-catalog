db.auth('root', 'example');
db = db.getSiblingDB('recommendation');
db.createUser(
    {
        user: "recommender",
        pwd: "recommender",
        roles: [
            { role: "readWrite", db: "recommendation" }
        ]
    });