function getItems() {
    var n = document.getElementById("selectCategory").options.selectedIndex;
    x = document.getElementById("selectCategory").options[n].value;
    $.ajax({
        type: "GET",
        url: "/admin/getItems",
        data: { name: x}
    }).done(function( msg ) {
        document.getElementById("itemBox").innerHTML=msg;
    });
}


function removeItem() {
    if(document.getElementById("selectItem")!==null) {
        var n = document.getElementById("selectItem").options.selectedIndex;
        x = document.getElementById("selectItem").options[n].value;
        if(x!=="") {
            $.ajax({
                type: "GET",
                url: "/admin/removeItem",
                data: {name: x}
            }).done(function (msg) {
                document.getElementById("itemBox").innerHTML = msg;
            });
        }else alert("choose item");
    }else alert("choose item");
}