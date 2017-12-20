/**
 * Author: Vijayan Chendrayan
 */

var pgc = jQuery.noConflict();

/**
 * This method belonging to clearing the inputs in all the forms.
 */	
function clearInputs(element)
{
	pgc(element).find(':input').each(function()
	{
        switch(this.type) {
            case 'password':
            case 'select-multiple':
            case 'select-one':
            case 'text':
            case 'textarea':
            	pgc(this).val('');
            	break;
            case 'checkbox':
            case 'radio':
            	this.checked = '';
        }
    });
}