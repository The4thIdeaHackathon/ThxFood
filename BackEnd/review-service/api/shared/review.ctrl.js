const models = require('../../models');

//GET /review

const index = (req, res) => {

    models.review.findAll({

        limit: 10,
        order: [['id','DESC']],
    
    }).then (result => {

        if(!result) return status(404).end();
        res.json(result);
    
    }).catch(err => {

        console.log(err);

    });

}

//GET review/:id
//
const show = (req, res) => {

    const id = parseInt(req.params.id);
    console.log("id : ", id);
    if(Number.isNaN(id))
    {
        models.review.findAll(
        {
            where: { id }

        }).then ( result => {
            
            if(!result) return status(404).end();
            res.json(result);

        }).catch( err => {
            
            console.log(err);
        })
    }else
    {
        models.review.findOne(
        {
            where: { id }
        }).then(result => {
            
            if(!result) return status(404).end();
            res.json(result);

        }).catch(err => {
            
            console.log(err);
        });
    }

}


//POST /review
const create = (req, res) => {

    var result= {};

    const input_writer = req.body.writer;
    const input_store = req.body.store;
    const input_point = parseInt(req.body.point);
    const input_content = req.body.content;
    

    if(!input_writer || !input_store || !input_point || !input_content )
    {
       
        result["success"] = 0;
        result["error"]="Invalid Data";
        res.json(result);
        return res.status(400).end();

    }


    const reviewing = {
        
        writer : input_writer,
        store : input_store,
        point : input_point,
        content : input_content
    }


    console.log(reviewing);
    
    models.review.create(reviewing)
        .then(result => {
            res.json(reviewing);
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

    models.review.destroy(
    {
        where : { id } 
    
    }).then( () => {

        res.status(204).end();
        
    }).catch(err => {
            
            console.log(err);
    });
    
}

const health = (req, res) => {

    console.log("Health check");
    res.json({"status": "UP"});

}



module.exports = {index, create, show,  destroy,  health};
