$(document).ready(function () {


    $("#btnSubmit").click(function (event) {

        if ($("#destPath").val().length > 1) {

            //stop submit the form, we will post it manually.
            event.preventDefault();

            var sitePath = $("#destPath").val();
            var searchOperation = $("#searchOperation").val();

            // disabled the submit button
            $("#btnSubmit").prop("disabled", true);

            $(".loading").removeClass("loading--hide").addClass("loading--show");
            $(".result label").hide();

            $.ajax({
                url: "/poc/solr-search",
                type: "GET",
                "data": {
                    "sitePath": sitePath,
                    "searchOperation": searchOperation

                },
                success: function (response) {

                    $(".result label").text(response);
                    $(".result label").css("color","green");
                    $(".result label").css("font-weight","bold");
                    $(".result label").show();
                    $(".loading").removeClass("loading--show").addClass("loading--hide");
                    $("#btnSubmit").prop("disabled", false);

                },
                error: function (e) {

                    $(".result label").text(e.responseText);
                    $(".result label").show();
                    $(".loading").removeClass("loading--show").addClass("loading--hide");
                    $("#btnSubmit").prop("disabled", false);

                }
            });
        }
        else
        {
            alert("Please, fill the mandatory fields");
            // Cancel the form submission
            event.preventDefault();
            return;
        }



    });

});