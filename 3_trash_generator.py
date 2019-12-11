def read_text_from_file(filename):
    fin = open(filename, "r")
    text = fin.read()
    fin.close()
    return text

def text_to_dictionary(text):
    wordList = text.split()
