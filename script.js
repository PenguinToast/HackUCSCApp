//Get the context of the canvas element we want to select
console.log(document);
var ctx = document.getElementById("myChart").getContext("2d");

data = {
	labels : ["5:00AM","","","","","",""],
	datasets : [
		{
			fillColor : "rgba(220,220,220,0.5)",
			strokeColor : "rgba(220,220,220,1)",
			pointColor : "rgba(220,220,220,1)",
			pointStrokeColor : "#fff",
			data : [65,59,90,-81,56,55,40]
		}
	]
}

options = {
    onAnimationComplete : drawRect
}

var chart = new Chart(ctx).Line(data, options);

function drawRect() {
    ctx.fillStyle = "#fF0000";
    ctx.globalAlpha = 0.5;
    ctx.fillRect(0, 0, 100, 100);

}
function getData()  {
	var xmlhttp=new XMLHttpRequest();
	xmlhttp.onreadystatechange=function() {
		if (xmlhttp.readyState==4 && xmlhttp.status==200) {
			var data=JSON.parse(xmlhttp.responseText);
			console.log(data);
			for (var x = 0; x < data.beaches.length; x++ ) {
				console.log("OMGOGMOGOGMOGMGO");
				var myLatlng = new google.maps.LatLng(data.beaches[x].latitude,data.beaches[x].longitude);
				arr[x] = myLatlng;
				console.log(arr[x]);
				}
			initialize(arr);
		}
	}
	xmlhttp.open("GET","http://penguintoast.no-ip.biz:8080/api/details?id=0" ,true);
	xmlhttp.send();
}
