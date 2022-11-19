import 'package:book_tracker/screens/home_page.dart';
import 'package:flutter/material.dart';

import '../controller/book_controller.dart';
import '../models/Book.dart';
import '../repository/book_repository.dart';

class UpdatePage extends StatefulWidget {
  final String? selectedId;
  final String? selectedTitle;
  final String? selectedDesc;
  final String? selectedAuthor;
  final String? selectedCategory;
  final String? selectedCompleted;

  // ignore: use_key_in_widget_constructors
  const UpdatePage(
      {required this.selectedId,
      required this.selectedTitle,
      required this.selectedDesc,
      required this.selectedAuthor,
      required this.selectedCategory,
      required this.selectedCompleted});

  @override
  State<UpdatePage> createState() => _UpdatePageState();
}

class _UpdatePageState extends State<UpdatePage> {
  final formKey = GlobalKey<FormState>();
  String selectedRadio = "";
  TextEditingController id = TextEditingController();
  TextEditingController title = TextEditingController();
  TextEditingController desc = TextEditingController();
  TextEditingController author = TextEditingController();
  TextEditingController category = TextEditingController();
  String completed = "";

  @override
  void initState() {
    id.text = widget.selectedId!;
    title.text = widget.selectedTitle!;
    desc.text = widget.selectedDesc!;
    author.text = widget.selectedAuthor!;
    category.text = widget.selectedCategory!;
    completed = widget.selectedCompleted!;

    super.initState();
  }

  setSelectedRadio(String val) {
    setState(() {
      selectedRadio = val;
    });
  }

  @override
  Widget build(BuildContext context) {
    var bookController = BookController(BookRepository());
    return Scaffold(
      appBar: AppBar(
          backgroundColor: Colors.transparent,
          title: const Text(
            "Edit",
            style: TextStyle(
              fontSize: 25,
              color: Colors.black,
            ),
          ),
          elevation: 0,
          leading: const BackButton(
            color: Colors.black,
          )),
      body: SingleChildScrollView(
        child: Container(
          padding: const EdgeInsets.only(
            right: 40,
            left: 40,
          ),
          child: Form(
            key: formKey,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                const SizedBox(height: 5),
                TextFormField(
                  enabled: false,
                  controller: id,
                  decoration: const InputDecoration(
                    labelText: "ID",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  controller: title,
                  decoration: const InputDecoration(
                    labelText: "Title",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  controller: desc,
                  decoration: const InputDecoration(
                    labelText: "Description",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  controller: author,
                  decoration: const InputDecoration(
                    labelText: "Author",
                  ),
                ),
                const SizedBox(height: 30),
                TextFormField(
                  controller: category,
                  decoration: const InputDecoration(
                    labelText: "Category",
                  ),
                ),
                const SizedBox(height: 30),
                Row(
                  children: [
                    const Text("Completed"),
                    Radio(
                      value: "Yes",
                      groupValue: selectedRadio,
                      onChanged: (val) {
                        setSelectedRadio(val.toString());
                      },
                    ),
                    const Text("Yes"),
                    Radio(
                      value: "No",
                      groupValue: selectedRadio,
                      onChanged: (val) {
                        setSelectedRadio(val.toString());
                      },
                    ),
                    const Text("No"),
                  ],
                ),
                Container(
                  alignment: Alignment.bottomRight,
                  child: ElevatedButton(
                    onPressed: () {
                      var _id = widget.selectedId;
                      var _title = title.text;
                      var _desc = desc.text;
                      var _author = author.text;
                      var _category = category.text;
                      var _completed = selectedRadio;
                      Book book = Book(
                        id: _id,
                        title: _title,
                        description: _desc,
                        author: _author,
                        category: _category,
                        completed: _completed,
                      );
                      bookController.putBook(book).then((value) {
                        ScaffoldMessenger.of(context).showSnackBar(
                          const SnackBar(
                            backgroundColor: Colors.blue,
                            duration: Duration(
                              milliseconds: 1500,
                            ),
                            content: Text("Book Edited!"),
                          ),
                        );
                      });

                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => const HomePage(),
                        ),
                      );
                    },
                    child: const Text("Save"),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
