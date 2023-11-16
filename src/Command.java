public interface Command {
/**
* コマンドを実行する．
*/
void execute();
/**
* コマンドをundoする．
*/
void undo();
}