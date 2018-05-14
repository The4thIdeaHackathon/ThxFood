const models = require('../../models');

//GET /sharing

const index = (req, res) => {

    models.sharing.findAll({

        limit: 10,
        order: [['id','DESC']],
    
    }).then (result => {

        if(!result) return status(404).end();
        res.json(result);
    
    }).catch(err => {

        console.log(err);

    });

}

//POST /sharing
const create = (req, res) => {

    var result= {};
    const input_store = req.body.store;
    const input_product = req.body.product;
    const input_htpurchase = req.body.htpurchase;
    const input_amount = parseInt(req.body.amount);
    const input_price = req.body.price;
    
    console.log("input_amount" + input_amount);

    if(!input_store || !input_product || !input_htpurchase || !input_amount || !input_price )
    {
       
        result["success"] = 0;
        result["error"]="Invalid Data";
        res.json(result);
        return res.status(400).end();

    }


    const shared = {
        
        store : input_store,
        product : input_product,
        htpurchase : input_htpurchase,
        amount: input_amount,
        price: input_price
    }


    console.log(shared);
    
    models.sharing.create(shared)
        .then(result => {
            res.json(shared);
            res.status(200).end();
        })
        .catch( err => {

            if(err){
                console.log(err);
                return res.status(400).end();
            }
        res.status(500).end();
        })

}

const destroy = (req,res) => {

    const id = parseInt(req.params.id);

    if(Number.isNaN(id))
    {
        return res.status(400).end();
    }

    console.log("id :", id);

    models.sharing.destroy(
    {
        where : {id}
    
    }).then( () => {

        res.status(204).end();
        
    }).catch(err => {
            
            console.log(err);
    });
    
}
    
const health =(req, res) => {

    console.log("Health check");
    res.json({"status": "UP"});


}





module.exports = {index, create, destroy,  health};
