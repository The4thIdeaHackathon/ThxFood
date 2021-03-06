const Sequelize = require('sequelize');
const sequelize = new Sequelize('HDW','HDW','HDW', {

    host: '210.117.134.88',
    dialect: 'mysql'
});

const sharing = sequelize.define('sharing', {
    
    id: {
        type: Sequelize.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    store: {
        type: Sequelize.STRING,
        allowNull: false
    },
    product: {
        type: Sequelize.STRING,
        allowNull: false
    },
    htpurchase: {
        type: Sequelize.STRING,
        allowNull: false
    },
    amount: {
        type: Sequelize.INTEGER,
        allowNull: false
    },
    price : {
        type: Sequelize.STRING,
        allowNull: false
    },
        
}, {

    timestamps: false, //createdAt, updatedAt column을 생성한다.
    paranoid: false, // deletedAt Column이 table에 추가된다. 해당 row삭제시 삭제된 날짜가 추가되며 이row는 find작업시 제외된다. 즉 data는 삭제되지 않지만, 삭제된 효과를 준다.
    tableName: 'sharing'
})

module.exports = {Sequelize, sequelize, sharing};

    

