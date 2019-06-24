function confirmDeleteElement(id, element) {
    if (confirm("Czy chcesz usunąć '" + element + "' ?")) {
        window.location.href = "/admin/stand/delete/" + id;
    }
}
