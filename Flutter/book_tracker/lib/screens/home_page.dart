// ignore_for_file: deprecated_member_use

import 'package:book_tracker/repository/book_repository.dart';
import 'package:book_tracker/screens/profile_page.dart';
import 'package:book_tracker/screens/update_page.dart';
import 'package:flutter/material.dart';

import '../controller/book_controller.dart';
import '../models/Book.dart';
import 'add_page.dart';
import 'book_info_page.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  var currentIndex = 0;
  @override
  Widget build(BuildContext context) {
    // dependecy injection
    var bookController = BookController(BookRepository());
    bool isFabVisible = true;
    return Scaffold(
      body: currentIndex == 0
          ? FutureBuilder<List<Book>>(
              future: bookController.fetchBooks(),
              builder: ((context, snapshot) {
                if (snapshot.connectionState == ConnectionState.waiting) {
                  return const Center(
                    child: CircularProgressIndicator(),
                  );
                }

                if (snapshot.hasError) {
                  return const Center(
                    child: Text("error"),
                  );
                }
                return SafeArea(
                  child: ListView.separated(
                      physics: const BouncingScrollPhysics(),
                      itemBuilder: (context, index) {
                        var book = snapshot.data?[index];
                        return GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) => BookInfo(
                                  selectedId: book?.id,
                                  selectedTitle: book?.title,
                                  selectedDesc: book?.description,
                                  selectedAuthor: book?.author,
                                  selectedCategory: book?.category,
                                  selectedCompleted: book?.completed,
                                ),
                              ),
                            );
                          },
                          // child: Container(
                          //   height: 100.0,
                          //   padding: const EdgeInsets.symmetric(
                          //     horizontal: 16.0,
                          //   ),
                          child: Padding(
                            padding: const EdgeInsets.symmetric(
                              vertical: 35.0,
                              horizontal: 20,
                            ),
                            child: Row(
                              children: [
                                Expanded(flex: 1, child: Text('${book?.id}')),
                                Expanded(
                                    flex: 3,
                                    child: Column(
                                      crossAxisAlignment:
                                          CrossAxisAlignment.start,
                                      children: [
                                        Text('${book?.title}'),
                                        Padding(
                                          padding:
                                              const EdgeInsets.only(top: 10),
                                          child: Text(
                                            'Completed: ${book?.completed}',
                                            style: const TextStyle(
                                                fontStyle: FontStyle.italic,
                                                fontSize: 10),
                                          ),
                                        ),
                                      ],
                                    )),
                                Expanded(
                                  flex: 1,
                                  child: Row(
                                    mainAxisAlignment:
                                        MainAxisAlignment.spaceBetween,
                                    children: [
                                      // inkwell allows us to click on any component

                                      InkWell(
                                        child: const Icon(Icons.edit,
                                            color: Colors.blue),
                                        onTap: () {
                                          var id = book?.id;
                                          var title = book?.title;
                                          var desc = book?.description;
                                          var author = book?.author;
                                          var category = book?.category;
                                          var completed = book?.completed;
                                          Navigator.push(
                                            context,
                                            MaterialPageRoute(
                                              builder: (context) => UpdatePage(
                                                selectedId: id,
                                                selectedTitle: title,
                                                selectedDesc: desc,
                                                selectedAuthor: author,
                                                selectedCategory: category,
                                                selectedCompleted: completed,
                                              ),
                                            ),
                                          );
                                        },
                                      ),
                                      InkWell(
                                        child: const Icon(Icons.delete,
                                            color: Colors.red),
                                        onTap: () {
                                          showDialog(
                                            context: context,
                                            builder: (context) => AlertDialog(
                                              title: const Text("Delete?"),
                                              content: const Text(
                                                  "Are you sure you want to delete this book?"),
                                              actions: [
                                                TextButton(
                                                  onPressed: () {
                                                    bookController
                                                        .deleteBook(book!)
                                                        .then(
                                                      (value) {
                                                        ScaffoldMessenger.of(
                                                                context)
                                                            .showSnackBar(
                                                          const SnackBar(
                                                            backgroundColor:
                                                                Colors.red,
                                                            duration: Duration(
                                                              milliseconds:
                                                                  1500,
                                                            ),
                                                            content: Text(
                                                              "Book Deleted!",
                                                            ),
                                                          ),
                                                        );
                                                      },
                                                    );
                                                    setState(() {});
                                                    Navigator.pop(context);
                                                  },
                                                  child: const Text("Yes"),
                                                ),
                                                TextButton(
                                                  onPressed: () {
                                                    Navigator.pop(context);
                                                  },
                                                  child: const Text("No"),
                                                ),
                                              ],
                                            ),
                                          );
                                        },
                                      ),
                                    ],
                                  ),
                                ),
                              ],
                            ),
                          ),
                          // ),
                        );
                      },
                      separatorBuilder: (context, index) {
                        return const Divider(
                          thickness: 0.5,
                          height: 0.5,
                        );
                      },
                      itemCount: snapshot.data?.length ?? 0),
                );
              }))
          : const ProfilePage(),
      bottomNavigationBar: BottomNavigationBar(
          items: const [
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: "Home",
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.account_circle_outlined),
              label: "Profile",
            ),
          ],
          currentIndex: currentIndex,
          onTap: (int index) {
            setState(() {
              currentIndex = index;
            });
          }),
      floatingActionButton: Visibility(
        visible: isFabVisible,
        child: FloatingActionButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => const AddPage(),
              ),
            );
          },
          tooltip: 'Increment',
          child: const Icon(Icons.add),
        ),
      ),
    );
  }
}
