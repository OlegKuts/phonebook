//var notesUrl = window.location.protocol + window.location.host + "/api/notes";
var globalAppUrl = window.location.href.toString();
var cutPoint = globalAppUrl.toLowerCase().indexOf("/notes");
globalAppUrl = globalAppUrl.substr(0, cutPoint);
var notesUrl = globalAppUrl + "/api/notes";
var notes;

$("document").ready(function() {
    initData();
    filterByName();
    filterByLastName();
    filterByCellNumber();
});

function initData() {
    $.get(notesUrl).done(function(data) {
        notes = data;
        var html = '';
        data.forEach(function(note) {
            html += `<tr>
		<td>${note.name}</td>
		<td>${note.lastName}</td>
		<td>${note.middleName}</td>
		<td>${note.cellNumber}</td>
		<td>${note.phoneNumber}</td>
		<td>${note.email}</td>
		<td>${note.address.city}</td>
		<td>${note.address.street}</td>
		<td><a class="btn btn-warning btn-xs"
			href="/notes/edit/${note.id}">Edit</a></td>
		<td><form  method="post" action="/notes/delete/${note.id}"><input type="submit" value="Delete"
			class="btn btn-danger btn-xs" /></form></td>
	</tr>`;
        });

        $("tbody").append(html);
    });
}

function filterByName() {
    var searchQuery = $("#nameFilter").val();
    $("#nameFilter").keyup(function() {
        searchQuery = $("#nameFilter").val().toLowerCase();
        $("tbody > tr").not(':first').remove();
        var filteredNotes = notes.filter(function(entry) {
            return entry.name.toLowerCase().startsWith(searchQuery);
        });
        var html = '';
        filteredNotes.forEach(function(note) {
            html += `<tr>
		<td>${note.name}</td>
		<td>${note.lastName}</td>
		<td>${note.middleName}</td>
		<td>${note.cellNumber}</td>
		<td>${note.phoneNumber}</td>
		<td>${note.email}</td>
		<td>${note.address.city}</td>
		<td>${note.address.street}</td>
		<td><a class="btn btn-warning btn-xs"
			href="/notes/edit/${note.id}">Edit</a></td>
		<td><form  method="post" action="/notes/delete/${note.id}"><input type="submit" value="Delete"
			class="btn btn-danger btn-xs" /></form></td>
	</tr>`;
        });
        $("tbody").append(html);

    });
}

function filterByLastName() {
    var searchQuery = $("#lastNameFilter").val();
    $("#lastNameFilter").keyup(function() {
        searchQuery = $("#lastNameFilter").val().toLowerCase();
        $("tbody > tr").not(':first').remove();
        var filteredNotes = notes.filter(function(entry) {
            return entry.lastName.toLowerCase().startsWith(searchQuery);
        });
        var html = '';
        filteredNotes.forEach(function(note) {
            html += `<tr>
		<td>${note.name}</td>
		<td>${note.lastName}</td>
		<td>${note.middleName}</td>
		<td>${note.cellNumber}</td>
		<td>${note.phoneNumber}</td>
		<td>${note.email}</td>
		<td>${note.address.city}</td>
		<td>${note.address.street}</td>
		<td><a class="btn btn-warning btn-xs"
			href="/notes/edit/${note.id}">Edit</a></td>
		<td><form  method="post" action="/notes/delete/${note.id}"><input type="submit" value="Delete"
			class="btn btn-danger btn-xs" /></form></td>
	</tr>`;
        });
        $("tbody").append(html);
    });
}

function filterByCellNumber() {
    var searchQuery = $("#cellNumberFilter").val();
    $("#cellNumberFilter").keyup(function() {
        searchQuery = $("#cellNumberFilter").val().toLowerCase();
        $("tbody > tr").not(':first').remove();
        var filteredNotes = notes.filter(function(entry) {
            return entry.cellNumber.toLowerCase().replace("(","").replace(")","").indexOf(searchQuery) > -1;
        });
        var html = '';
        filteredNotes.forEach(function(note) {
            html += `<tr>
		<td>${note.name}</td>
		<td>${note.lastName}</td>
		<td>${note.middleName}</td>
		<td>${note.cellNumber}</td>
		<td>${note.phoneNumber}</td>
		<td>${note.email}</td>
		<td>${note.address.city}</td>
		<td>${note.address.street}</td>
		<td><a class="btn btn-warning btn-xs"
			href="/notes/edit/${note.id}">Edit</a></td>
		<td><form  method="post" action="/notes/delete/${note.id}"><input type="submit" value="Delete"
			class="btn btn-danger btn-xs" /></form></td>
	</tr>`;
        });
        $("tbody").append(html);
    });
}