var express = require('express');
var mysql = require('mysql');
var morgan = require('morgan');
var bodyParser = require('body-parser');
var app = express();
var sharing = require('./api/shared');
var db = require('./models');
var cors = require('cors');


if (process.env.NODE_ENV !== 'test')
{
    app.use(morgan('dev'));
}

db.sequelize.sync()
    .then(() => {
        console.log("DB Connection Success");
        console.log(" Press CTRL-C to stop\n");
    })
    .catch(err => {
        console.error(err);
        console.log("Connection error");
        process.exit();
    });

app.use(express.static('public'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));
app.use(cors());
app.use('/sharing', sharing);
/*
function connectToEureka()
{
    EurekaClient.logger.level('debug');
    EurekaClient.start(function(error){
        console.log("####################################");
        console.log(JSON.stringify(error) || 'Eurekai registration complete');
    })
}

connectToEureka();
*/
module.exports = app;

