from dataclasses import dataclass
from prompt_toolkit import prompt
from prompt_toolkit.completion import WordCompleter, PathCompleter


@dataclass
class Type:
    path: str
    className: str

    def __init__(self, path: str, className: str) -> None:
        self.path = path
        self.className = className


class Formatter:

    @staticmethod
    def format(type: Type, filepath: str):
        with open(filepath) as file:
            for line in file.readlines():
                if Formatter.__has_package(line):
                    continue
                if Formatter.__is_comment(line):
                    continue
                line = Formatter.__replace_classname(line, type.className)
                line = line.replace('\n', '')
                print(line)

    @staticmethod
    def __has_package(line: str) -> bool:
        return line.startswith("package")

    @staticmethod
    def __replace_classname(line: str, newClassName: str) -> str:
        class_declation = "public class "
        if line.startswith(class_declation):
            classname = line[len(class_declation):len(line) - 3]
            return line.replace(classname, newClassName)
        else:
            return line

    @staticmethod
    def __is_comment(line: str) -> bool:
        return line.startswith("//") or line.startswith("/**") or line.startswith("**/")


types = {
    'baekjoon': Type(path='src/main/java/baekjoon/', className="Main"),
    'programmers': Type(path='src/main/java/programmers/', className="Solution")
}

type_completer = WordCompleter(list(types))

type = prompt('type> ', completer=type_completer, complete_while_typing=True)

if type not in list(types):
    print("Type must be in %s" % list(types))
    exit()

path = prompt('path> ', completer=PathCompleter(
    get_paths=lambda: [types[type].path],
    min_input_len=1
), complete_while_typing=True)

if path.endswith(".java"):
    Formatter.format(type=types[type], filepath=types[type].path + path)
else:
    print("Path can only java file")
