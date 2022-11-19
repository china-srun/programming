import '../models/Book.dart';
import '../repository/repository.dart';

class BookController {
  final Repository _repository;
  BookController(this._repository);

  // get
  Future<List<Book>> fetchBooks() async {
    return _repository.getBooks();
  }

  // update
  Future<String> updatePatchCompleted(Book book) async {
    return _repository.patchCompleted(book);
  }

  //delete
  Future<String> deleteBook(Book book) async {
    return _repository.deletedBook(book);
  }

  // post
  Future<String> postBook(Book book) async {
    return _repository.postBook(book);
  }

  // post
  Future<String> putBook(Book book) async {
    return _repository.putCompleted(book);
  }
}
