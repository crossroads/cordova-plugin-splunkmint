/*
* now everything is done on inizialization of the plugin so no js method needed
*/

module.exports = function(){};

var exec = require('cordova/exec');

function Splunkmint() {}

Splunkmint.prototype.initiate = function(key){

  exec(function(){},
    function(){},
    "Splunkmint",
    "",
    [key]
  );

}

var splunkMint = new Splunkmint();
module.exports = splunkMint;
