const confirmDelete = document.querySelector("#deleteFarm");

confirmDelete.addEventListener("click", () => {
    confirm("Are you sure you want to delete this farm?");
});
