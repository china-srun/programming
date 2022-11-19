// ignore_for_file: no_leading_underscores_for_local_identifiers

import 'package:book_tracker/screens/home_page.dart';
import 'package:flutter/material.dart';

import '../controller/book_controller.dart';
import '../models/Book.dart';
import '../repository/book_repository.dart';

class AddPage extends StatefulWidget {
  const AddPage({Key? key}) : super(key: key);

  @override
  State<AddPage> createState() => _AddPageState();
}

class _AddPageState extends State<AddPage> {
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
    super.initState();
    selectedRadio = "Yes";
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
            "Add Book",
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
                      controller: id,
                      decoration: const InputDecoration(
                        labelText: "ID",
                      ),
                      validator: (value) {
                        if (value!.isNotEmpty) {
                          return null;
                        } else {
                          return "Field cannot be emptied.";
                        }
                      },
                    ),
                    const SizedBox(height: 30),
                    TextFormField(
                      controller: title,
                      decoration: const InputDecoration(
                        labelText: "Title",
                      ),
                      validator: (value) {
                        
                        if (value!.isNotEmpty) {
                          return null;
                        } else {
                          return "Field cannot be emptied.";
                        }
                      },
                    ),
                    const SizedBox(height: 30),
                    TextFormField(
                      controller: desc,
                      decoration: const InputDecoration(
                        labelText: "Description",
                      ),
                      validator: (value) {
                        if (value!.isNotEmpty) {
                          return null;
                        } else {
                          return "Field cannot be emptied.";
                        }
                      },
                    ),
                    const SizedBox(height: 30),
                    TextFormField(
                      controller: author,
                      decoration: const InputDecoration(
                        labelText: "Author",
                      ),
                      validator: (value) {
                        if (value!.isNotEmpty) {
                          return null;
                        } else {
                          return "Field cannot be emptied.";
                        }
                      },
                    ),
                    const SizedBox(height: 30),
                    TextFormField(
                      controller: category,
                      decoration: const InputDecoration(
                        labelText: "Category",
                      ),
                      validator: (value) {
                        if (value!.isNotEmpty) {
                          return null;
                        } else {
                          return "Field cannot be emptied.";
                        }
                      },
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
                          if (!formKey.currentState!.validate()) {
                            return;
                          }
                          var _id = id.text;
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
                          bookController.postBook(book).then((value) {
                            ScaffoldMessenger.of(context).showSnackBar(
                              const SnackBar(
                                backgroundColor: Colors.green,
                                duration: Duration(
                                  milliseconds: 1500,
                                ),
                                content: Text("Book Added!"),
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
                ))),
      ),
    );
  }
}
