var browserLang = navigator.languages && navigator.languages[0] || // Chrome // Firefox
navigator.language || // All browsers 
navigator.userLanguage; // IE <= 10
var paramValue = null;

function getParameter(name) {
	var url_string = window.location.href; // www.test.com?filename=test
	var url = new URL(url_string);
	var param = url.searchParams.get(name);
	return param;
}

function getDate() {
	paramValue = getParameter("language");
	console.log("param.language = " + paramValue);
	if (paramValue == null)
		paramValue = browserLang;
	console.log("param.language = " + paramValue);
	console.log("window.navigator = " + browserLang);

	const m = moment();
	m.locale(paramValue);
	console.log(m.format('LLL'));
	$("#date").append(m.format('LLL'));
}

$(document).ready(function() {
	getDate();
	$("html").attr("lang", paramValue);
	$("#locales").change(function() {
		var selectedOption = $('#locales').val();
		if (selectedOption != '') {
			window.location.replace('?language=' + selectedOption);
		}
	});
});
