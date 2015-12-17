/*
* now everything is done on inizialization of the plugin so no js method needed
*/

module.exports = function(){};


var exec = require('cordova/exec');

function Splunkmint() {}

Splunkmint.prototype.initiate = function(key){

 exec(function(result){
    /*alert("OK" + reply);*/
  },
  function(result){
    /*alert("Error" + reply);*/
  },"Splunkmint",key,[]);
}

 var splunkMint = new Splunkmint();
 module.exports = splunkMint;
