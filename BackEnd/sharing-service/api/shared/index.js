const express = require('express');
const router = express.Router();
//const ctrl = require('./user.ctrl');
const ctrl = require('./sharing.ctrl');

//router.get('/', ctrl.index);
//router.get('/:id', ctrl.show);
//router.delete('/:id',ctrl.destroy);
//router.post('/',ctrl.create);

router.get('/', ctrl.index);
router.get('/health', ctrl.health);
router.post('/', ctrl.create);
router.delete('/:id',ctrl.destroy);


module.exports = router;
