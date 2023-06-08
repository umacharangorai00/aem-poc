(function ($, $document) {
  'use strict';

  $document.on('dialog-ready', function () {
    let topBarSwitch = $(".cq-dialog-checkbox-showhide-top-bar");
    let modalLinkSwitch = $(".cq-dialog-checkbox-showhide-modal-link");

    showHideTabsBasedOnSwitch(topBarSwitch, modalLinkSwitch);

    topBarSwitch.change(function () {
      showHideTabsBasedOnSwitch(topBarSwitch, modalLinkSwitch);
    });
    modalLinkSwitch.change(function () {
      showHideTabsBasedOnSwitch(topBarSwitch, modalLinkSwitch);
    });
  });

  function showHideTabsBasedOnSwitch(topBarSwitch, modalLinkSwitch) {
    let editorialTabs = $('.cq-dialog-editorial-tabs');
    let groupTab = editorialTabs.find('coral-tab-label:contains("Group")').parent();
    let divisionsTab = editorialTabs.find('coral-tab-label:contains("Divisions")').parent();
    let brandsTab = editorialTabs.find('coral-tab-label:contains("Brands")').parent();
    let topBarLinksSection = $(".showhidetarget-top-bar-links-section");

    if (!topBarSwitch.attr("checked")) {
      groupTab.addClass("hide");
      divisionsTab.addClass("hide");
      brandsTab.addClass("hide");
      topBarLinksSection.addClass("hide");
    } else if (!modalLinkSwitch.attr("checked")) {
      groupTab.addClass("hide");
      divisionsTab.addClass("hide");
      brandsTab.addClass("hide");
      topBarLinksSection.removeClass("hide");
    } else {
      groupTab.removeClass("hide");
      divisionsTab.removeClass("hide");
      brandsTab.removeClass("hide");
      topBarLinksSection.removeClass("hide");
    }
  }

})($, $(document));
