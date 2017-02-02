$(document).ready(function () {
    $('#resultId').click(function () {
        var countryName=$('#selecedCountryId').val();
        var content=document.getElementById('resultDiv');
        $.ajax({
            url: 'ResultAction',
            type: 'POST',
            data: {selectedCountry: countryName},
            success: function (html) {
                content.innerHTML=html;
            }
        });
    });
});