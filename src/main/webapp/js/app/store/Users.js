// we now reference the Model instead of defining fields inline
Ext.define('AM.store.Users', {
	extend : 'Ext.data.Store',
	model : 'AM.model.User',
	data : [
		{ name : 'Ed', email : 'ed@sencha.com' },
		{ name : 'Tommy', email : 'tommy@sencha.com' }
	] });
