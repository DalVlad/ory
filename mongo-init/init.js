
db = db.getSiblingDB('product-service');

db.createUser({
user: 'product_user',
pwd: 'product_password',
roles: [
{
role: 'readWrite',
db: 'product-service'
}
]
});

db = db.getSiblingDB('notification-service');

db.createUser({
user: 'notification_user',
pwd: 'notification_password',
roles: [
{
role: 'readWrite',
db: 'notification-service'
}
]
});