import 'package:book_tracker/models/Book.dart';
import 'package:book_tracker/repository/repository.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class BookRepository implements Repository {
  // use http
  String dataUrl = "http://10.0.2.2:3000";

  @override
  Future<String> deletedBook(Book book) async {
    var url = Uri.parse('$dataUrl/allbooks/${book.id}');
    var result = 'false';
    await http.delete(url).then((value) {
      return result = "true";
    });
    return result;
  }

  @override
  Future<List<Book>> getBooks() async {
    // future -> async
    List<Book> books = [];
    var url = Uri.parse('$dataUrl/allbooks');
    var response = await http.get(url);
    var data = jsonDecode(response.body);
    // parse
    for (var i = 0; i < data['data'].length; i++) {
      books.add(Book.fromJson(data['data'][i]));
    }
    return books;
  }

  // update data
  @override
  Future<String> patchCompleted(Book book) async {
    var url = Uri.parse('$dataUrl/allbooks/${book.id}');
    // call back data
    String resData = "";
    await http.patch(
      url,
      body: {
        'completed': (0).toString(),
      },
      headers: {'Authorization': 'your_token'},
    ).then((response) {
      var data = json.decode(json.encode(response.body));
      Map<String, dynamic> result = data;
      return resData = result[""];
    });
    return resData;
  }

  @override
  Future<String> postBook(Book book) async {
    var url = Uri.parse('$dataUrl/allbooks/');
    final response = await http.post(
      url,
      headers: {
        'Content-Type': 'application/json',
      },
      body: json.encode(book),
    );

    return 'true';
  }

  @override
  Future<String> putCompleted(Book book) async {
    var url = Uri.parse('$dataUrl/allbooks/${book.id}');
    final response = await http.put(
      url,
      headers: {
        'Content-Type': 'application/json',
      },
      body: json.encode(book),
    );

    if (response.statusCode == 200) {
      print("updated successfully");
    } else {
      print("error");
    }

    return "true";
  }
}
