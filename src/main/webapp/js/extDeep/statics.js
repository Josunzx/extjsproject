Ext.define('Computer', {
    statics: {
        instanceCount: 0,
        factory: function(brand) {
            // 'this' in static methods refer to the class itself
            return new this({brand: brand});
        }
    },
    config: {
        brand: null
    },
    constructor: function(config) {
        this.initConfig(config);
        // the 'self' property of an instance refers to its class
        this.self.instanceCount ++;
        return this;
    }
});

var dellComputer = Computer.factory('Dell');
var appleComputer = Computer.factory('Mac');
alert(appleComputer.getBrand()); // using the auto-generated getter to get the value of a config property. Alerts "Mac"
alert(Computer.instanceCount); // Alerts "2"
