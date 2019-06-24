function confirmDeleteUser(id, username) {
    if (confirm("Czy chcesz usunąć '" + username + "' ?")) {
        window.location.href = "/admin/user/delete/" + id;
    }
}