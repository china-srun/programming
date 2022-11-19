import '../models/Book.dart';

abstract class Repository {
  // get
  Future<List<Book>> getBooks();

  // patch
  Future<String> patchCompleted(Book book);

  // put
  Future<String> putCompleted(Book book);

  // delete
  Future<String> deletedBook(Book book);

  // post
  Future<String> postBook(Book book);
}
