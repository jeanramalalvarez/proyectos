var idTabla="";

function changeLinks(id)
{
	idTabla = id;
    done=true;
    var linkData, queryArr, action, qryStr;
    selector = 'ul.paginacionListado>li>a';
    changeUsingSelector(selector);
    selector = 'table#dispTable>thead>tr>th>a';
    changeUsingSelector(selector);
}


function changeUsingSelector(selector)
{
    $(selector).each(function()
    {
        linkData = $(this).attr("href");
        queryArr = linkData.split("?");
        action = queryArr[0];
        qryStr = queryArr[1];
        newStr = "JavaScript:doAjax('"+action+"','"+qryStr+"','"+idTabla+"');";
        $(this).attr("href",newStr);
        $(this).attr("onMouseOver","window.status='';return true;");
        $(this).attr("onMouseOut","window.status='';return true;");
    });    

}
   
    


function doAjax(url, data, eleId)
{
	
    //if you need additional params to be passed - add to the data variable
    $.ajax
    ({
        url: url,
        data:  data,
        async: true,
        beforeSend: function(){$('#indicador').show();},
        success: function(resp){
            var d = $(resp); 
            htmlStr="";
            for(i=0;i<d.length;i++)
            {
                var node = d[i];
                if (node.id == eleId)
                {
                    htmlStr=$(node).html(); 
                    break;
                }
            }
            $('#'+eleId).html(htmlStr);
            changeLinks(idTabla);
        },
        complete: function(){$('#'+idTabla).effect("highlight", {}, 1000); $('#indicador').hide();}
    });

}
