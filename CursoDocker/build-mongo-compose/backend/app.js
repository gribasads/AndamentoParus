const express = require ('express')
const restful= require ('node-restful')
const server =express()
const mongoose= restful.mongoose
const cors = require('cors')

//Database
mongoose.Promisse = global.Promisse
mongoose.connect('mongodb://db/mydb')

//midlewares
server.use(bodyParser.urlencoded({extended:true}))
server.use(bodyParser.json())
server.use(cors())

//ODM
const Client = restful.model('Client',{
    name: { type: String, required: true}
})

//Rest API
Client.methods(['get','post','delete','put'])
Client.updateOptions({new: true, runValidators:true})

//Routes
Client.register(server,'/clients')


//Start server
server.listen(3000)