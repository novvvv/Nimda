document.addEventListener("DOMContentLoaded", function () {
  const mobileMenuButton = document.querySelector(".mobile-menu-button");
  const closeMenuButton = document.querySelector(".close-menu-button");
  const mobileMenuPopup = document.querySelector(".mobile-menu-popup");
  const popupDropdownLink = document.querySelector(".popup-dropdown-link");
  const popupDropdownContent = document.querySelector(".popup-dropdown-content");

  if (mobileMenuButton) {
    mobileMenuButton.addEventListener("click", function () {
      mobileMenuPopup.classList.add("active");
    });
  }

  if (closeMenuButton) {
    closeMenuButton.addEventListener("click", function () {
      mobileMenuPopup.classList.remove("active");
    });
  }

  // 어두운 배경 클릭 시 메뉴 닫기
  if (mobileMenuPopup) {
    mobileMenuPopup.addEventListener('click', function (event) {
      // 사이드바 영역이 아닌, 바깥 배경을 클릭했을 때만 닫힘
      if (event.target === mobileMenuPopup) {
        mobileMenuPopup.classList.remove('active');
      }
    });
  }

  // 모바일 바로가기 드롭다운 토글
  if (popupDropdownLink && popupDropdownContent) {
    popupDropdownLink.addEventListener('click', function (event) {
      event.preventDefault(); // 링크 기본 동작 방지
      popupDropdownContent.classList.toggle('active');
      popupDropdownLink.closest('.popup-dropdown').classList.toggle('active'); // 화살표 회전을 위해 부모에 active 클래스 토글
    });
  }
});
