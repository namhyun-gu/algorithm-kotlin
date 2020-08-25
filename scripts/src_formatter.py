from dataclasses import dataclass
from prompt_toolkit import prompt
from prompt_toolkit.completion import WordCompleter, PathCompleter
from prompt_toolkit.document import Document
from prompt_toolkit.validation import Validator, ValidationError
import os


@dataclass
class Type:
    path: str
    className: str

    def __init__(self, path: str, className: str) -> None:
        self.path = path
        self.className = className


types = {
    'baekjoon': Type(path='src/main/java/baekjoon/', className="Main"),
    'programmers': Type(path='src/main/java/programmers/', className="Solution")
}


class Formatter:
    @classmethod
    def __load_file__(self, filepath):
        with open(filepath) as file:
            for line in file.readlines():
                yield line

    @classmethod
    def __format_line__(self, type: Type, line: str) -> str:
        raise NotImplementedError

    @classmethod
    def format(self, filepath: str, type: Type):
        for line in self.__load_file__(filepath):
            formatted = self.__format_line__(type=type, line=line)
            if not formatted.startswith("-"):
                yield formatted


class JavaFormatter(Formatter):
    @classmethod
    def __format_line__(self, type: Type, line: str) -> str:
        if self.__has_package__(line):
            return "- " + line
        if self.__is_comment__(line):
            return "- " + line
        if self.__is_declare_class__(line):
            return self.__replace_classname__(line, type.className).replace('\n', '')
        return line.replace('\n', '')

    @classmethod
    def __has_package__(self, line: str) -> bool:
        return line.startswith("package")

    @classmethod
    def __is_declare_class__(self, line: str) -> bool:
        return line.startswith("public class ")

    @classmethod
    def __replace_classname__(self, line: str, newClassName: str) -> str:
        classname = line[len("public class "):len(line) - 3]
        return line.replace(classname, newClassName)

    @classmethod
    def __is_comment__(self, line: str) -> bool:
        return line.startswith("//") or line.startswith("/**") or line.startswith("**/")


class KotlinFormatter(Formatter):
    @classmethod
    def __format_line__(self, type: Type, line: str) -> str:
        if self.__has_package__(line):
            return "- " + line
        if self.__is_comment__(line):
            return "- " + line
        if self.__is_declare_class__(line):
            return self.__replace_classname__(line, type.className).replace('\n', '')
        return line.replace('\n', '')

    @classmethod
    def __has_package__(self, line: str) -> bool:
        return line.startswith("package")

    @classmethod
    def __is_declare_class__(self, line: str) -> bool:
        return line.startswith("class ")

    @classmethod
    def __replace_classname__(self, line: str, newClassName: str) -> str:
        classname = line[len("class "):len(line) - 3]
        return line.replace(classname, newClassName)

    @classmethod
    def __is_comment__(self, line: str) -> bool:
        return line.startswith("//") or line.startswith("/**") or line.startswith("**/")


class TypeValidator(Validator):
    def validate(self, document: Document) -> None:
        type = document.text
        if type not in list(types):
            raise ValidationError(message='Type must be in %s' % list(types))


class PathValidator(Validator):
    def validate(self, document: Document) -> None:
        path = document.text
        if not (path.endswith(".java") or path.endswith(".kt")) and not os.path.exists(path):
            raise ValidationError(message='Path can only java or kotlin file')


class RerunValidator(Validator):
    def validate(self, document: Document) -> None:
        path = document.text
        if not (path == 'y' or path == 'n'):
            raise ValidationError(message='Can only y or n')


type_completer = WordCompleter(list(types))

type = prompt('type> ',
              completer=type_completer,
              complete_while_typing=True,
              validator=TypeValidator(),
              validate_while_typing=True)

path = prompt('path> ',
              completer=PathCompleter(
                  get_paths=lambda: [types[type].path],
                  min_input_len=1
              ),
              complete_while_typing=True,
              validator=PathValidator(),
              validate_while_typing=True)


def run_formatter(type: Type, filepath: str):
    formatter: Formatter = None
    if filepath.endswith(".java"):
        formatter = JavaFormatter()
    elif filepath.endswith(".kt"):
        formatter = KotlinFormatter()

    for line in formatter.format(filepath, type):
        print(line)


rerun = True
while rerun:
    run_formatter(types[type], types[type].path + path)

    rerun = prompt('\nRe-run? (y/n) ', validator=RerunValidator(),
                   validate_while_typing=True)

    if rerun == 'n':
        rerun = False
