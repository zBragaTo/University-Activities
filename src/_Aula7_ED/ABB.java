package _Aula7_ED;

import java.util.LinkedList;

// Classe ABB: encarregada de manipular a estrutura de dados
// árvore de busca binária genérica.
// Autor 1: Manuel Fernandez Paradela Lédon.
// Data da Criação: 2013.
// Autor 2: Ivan Carlos Alcântara de Oliveira.
// Data da Adaptação: 10/10/2024. 15h.
// Autor 3: LEONARDO BRAGATO BASSI 10416029
// Data da Atualização: 19/11/2024
class ABB<E extends Comparable<E>> { // Árvore Binária de Busca

	private Node<E> raiz; // Node raiz da ABB
	private int size; // quantidade de nós da ABB

	// ABB(): Construtor que cria uma ABB vazia
	public ABB() {
		raiz = null;
		size = 0;
	}

	// isEmpty(): Verifica se ABB está vazia, retornando verdadeiro
	// se vazia ou falso, caso contrário
	public boolean isEmpty() {
		return (raiz == null);
	}

	// setRaiz(Node<E> raiz): Atribui a raiz da ABB
	public void setRaiz(Node<E> raiz) {
		this.raiz = raiz;
	}

	// getRaiz(): Retorna o Node raiz da ABB
	public Node<E> getRaiz() {
		return raiz;
	}

	// getSize(): retorna o total de nós (Nodes) na ABB.
	public int getSize() {
		return size;
	}

	// inserir(E valor): método encarregado de chamar o método que
	// insere um novo "valor" na ABB
	public E inserir(E valor) {
		try {
			Node<E> novo = new Node<E>(valor);
			this.inserir(novo, raiz);
			size++;
		} catch (Exception exMemoria) {
			return null;
		} // memória insuficiente
		return (valor);
	}

	/*
	 * inserir(Node<E> novo, Node<E> anterior): O Método 'inserir' utiliza o método
	 * 'compareTo', que deverá existir na classe de objetos a inserir na ABB. O
	 * método 'compareTo' da interface Comparable (implementado nas classes Double,
	 * Integer, String etc.) lançará uma exception se são comparados objetos de
	 * tipos diferentes. Consequentemente, este método 'inserir' só conseguirá
	 * adicionar novos nodos que guardem objetos do mesmo tipo que o objeto inicial
	 * guardado na ABB, ou seja, a ABB guardará objetos do mesmo tipo.
	 */
	private Node<E> inserir(Node<E> novo, Node<E> anterior) {
		if (raiz == null) { // ou if(isEmpty())
			raiz = novo; // ou setRaiz(novo);
			return raiz;
		}
		if (anterior == null) {
			return novo; // chegou em uma folha
		} else {
			if (novo.getValue().compareTo(anterior.getValue()) < 0) {
				anterior.setFilhoEsquerdo(inserir(novo, anterior.getFilhoEsquerdo()));
			} else {
				anterior.setFilhoDireito(inserir(novo, anterior.getFilhoDireito()));
			}
			return anterior;
		}
	}

	// emOrdem(): chama o método que vai percorrer a ABB em Ordem a partir do Node
	// raiz.
	public void emOrdem() {
		emOrdem(raiz);
	}

	// preOrdem(): chama o método que vai percorrer a ABB em pre Ordem a partir do
	// Node raiz.
	public void preOrdem() {
		preOrdem(raiz);
	}

	// posOrdem(): chama o método que vai percorrer a ABB em pos Ordem a partir do
	// Node raiz.
	public void posOrdem() {
		posOrdem(raiz);
	}

	// emOrdem(Node<E> no): percorre a ABB em Ordem a patir do raiz.
	public void emOrdem(Node<E> no) {
		if (no != null) {
			emOrdem(no.getFilhoEsquerdo());
			System.out.print(no.getValue());
			emOrdem(no.getFilhoDireito());
		}
	}

	// preOrdem(Node<E> no): percorre a ABB em pre Ordem a patir do raiz.
	public void preOrdem(Node<E> no) {
		if (no != null) {
			System.out.print(no.getValue());
			preOrdem(no.getFilhoEsquerdo());
			preOrdem(no.getFilhoDireito());
		}
	}

	// posOrdem(Node<E> no): percorre a ABB em pos Ordem a patir do raiz.
	public void posOrdem(Node<E> no) {
		if (no != null) {
			posOrdem(no.getFilhoEsquerdo());
			posOrdem(no.getFilhoDireito());
			System.out.print(no.getValue());
		}
	}

	// emNivel(): percorre a ABB em Nível (largura) a patir do raiz.
	public void emNivel() {
		// Método iterativo que utiliza uma fila auxiliar
		Node<E> noAux;
		LinkedList<Node<E>> fila = new LinkedList<Node<E>>();
		fila.addLast(raiz);
		while (!fila.isEmpty()) {
			noAux = (Node<E>) fila.removeFirst();
			if (noAux.getFilhoEsquerdo() != null) {
				fila.addLast(noAux.getFilhoEsquerdo());
			}
			if (noAux.getFilhoDireito() != null) {
				fila.addLast(noAux.getFilhoDireito());
			}
			System.out.print(noAux.getValue() + "   ");
		}
	}

	// getMenor(Node<E> node): determina o menor elemento a partir de um nó
	public Node<E> getMenor(Node<E> node) {
		if (isEmpty()) {
			return null;
		}
		if (node.getFilhoEsquerdo() == null) {
			return node;
		} else {
			return getMenor(node.getFilhoEsquerdo());
		}
	}

	// getMaior(Node<E> node): determina o maior elemento a partir de um nó
	public Node<E> getMaior(Node<E> node) {
		if (isEmpty()) {
			return null;
		}
		if (node.getFilhoDireito() == null) {
			return node;
		} else {
			return getMaior(node.getFilhoDireito());
		}
	}

	// getMax(Node<E> raiz, Node<E> paiRaiz): determina o
	// maior elemento a partir de um nó. Retorna o nó com o
	// maior valor da subárvore esquerda que começa em raiz.
	public Node<E> getMax(Node<E> raiz, Node<E> paiRaiz) {
		if (isEmpty()) {
			return null;
		}
		Node<E> aux;
		if (raiz.getFilhoDireito() == null) { // se não tiver mais filho direito
			aux = raiz;
			if (paiRaiz != null) { // se tiver um pai, ele assume o filho esquerdo
				if (paiRaiz.getFilhoEsquerdo() == raiz) { // se é filho esquerdo
					paiRaiz.setFilhoEsquerdo(raiz.getFilhoEsquerdo());
				} else {
					paiRaiz.setFilhoDireito(raiz.getFilhoEsquerdo());
				}
			}
			return aux;
		} else {
			return getMax(raiz.getFilhoDireito(), raiz);
		}
	}

	// compara(Object ob1, Object ob2): compara dois objetos com CompareTo
	private int compara(Object ob1, Object ob2) {
		return ((Comparable) ob1).compareTo(((Comparable) ob2));
	}

	// eliminar(Object e): chama o método que se encarrega de eliminar um elemento
	// a partir do raiz.
	public boolean eliminar(Object e) {
		boolean resultado = eliminar(raiz, null, e);
		if (resultado == true)
			size--;
		return resultado;
	}

	// eliminar(Node<E> node, Node<E> paiRaiz, Object e): método responsável por
	// eliminar
	// um objeto 'e' da ABB a patir do raiz.
	private boolean eliminar(Node<E> node, Node<E> paiRaiz, Object e) { // remove um elemento da árvore, retorna true ou
																		// false
		Node<E> aux;
		if (node == null) { // não achou o elemento, não existe (chegou em uma folha, ou árvore vazia)
			return false; // abandonamos o método retornando false, não foi possível eliminar
		} else { // a árvore ou sub-árvore não está vazia:
			if (compara(e, node.getValue()) == 0) { // se o nó a eliminar, node, foi encontrado (ele guarda o objeto e)
				aux = node;
				if (node.getFilhoEsquerdo() == null && node.getFilhoDireito() == null) { // caso A: se node não possui
																							// filhos, basta eliminar o
																							// nó
					if (paiRaiz == null) { // se o node a eliminar não tiver pai, ele era a raiz da árvore, então a
											// árvore ficou vazia
						setRaiz(null); // convenção para ABB vazia
					} else { // senão, o pai deve "deserdar" o filho (ficar sem esse filho eliminado)
						// verifica se o nó que será eliminado é o filho esquerdo ou direito do pai:
						if (paiRaiz.getFilhoEsquerdo() != null
								&& compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
							paiRaiz.setFilhoEsquerdo(null);
						} else if (paiRaiz.getFilhoDireito() != null
								&& compara(paiRaiz.getFilhoDireito().getValue(), e) == 0) {
							paiRaiz.setFilhoDireito(null);
						}
					}
				} else if (node.getFilhoDireito() == null) { // Caso B1: se node só tiver o filho esquerdo
					if (paiRaiz != null) { // se node tiver um pai, o pai (paiRaiz) assume o filho esquerdo de node
						// verifica se a raiz é filho esquerdo ou direito de paiRaiz, para assumir o
						// neto:
						if (paiRaiz.getFilhoEsquerdo() != null
								&& compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
							paiRaiz.setFilhoEsquerdo(node.getFilhoEsquerdo());
						} else {
							paiRaiz.setFilhoDireito(node.getFilhoEsquerdo());
						}
					} else { // se node não tiver pai (caso da raiz da árvore, paiRaiz é nulo), adotar seu
								// filho ou mover a raiz:
						node.setValue(node.getFilhoEsquerdo().getValue());
						raiz = raiz.getFilhoEsquerdo(); // mover a raiz da árvore
						// ou adotar o filho:
						// node.setFilhoEsquerdo(node.getFilhoEsquerdo().getFilhoEsquerdo());
						// node.setFilhoDireito(node.getFilhoEsquerdo().getFilhoDireito());
					}
				} else if (node.getFilhoEsquerdo() == null) { // Caso B2: se node só tiver o filho direito
					if (paiRaiz != null) { // se node tiver um pai, o pai (paiRaiz) assume o filho direito de node:
						// verifica se a raiz paiRaiz tem node como filho esquerdo ou direito, para
						// assumir o neto:
						if (paiRaiz.getFilhoEsquerdo() != null
								&& compara(paiRaiz.getFilhoEsquerdo().getValue(), e) == 0) {
							paiRaiz.setFilhoEsquerdo(node.getFilhoDireito());
						} else {
							paiRaiz.setFilhoDireito(node.getFilhoDireito());
						}
					} else { // se node não tiver pai (caso da raiz da árvore, paiRaiz é nulo), adotar seu
								// filho ou mover a raiz:
						node.setValue(node.getFilhoDireito().getValue());
						raiz = raiz.getFilhoDireito(); // mover a raiz da árvore
						// ou adotar o filho:
						// node.setFilhoEsquerdo(node.getFilhoDireito().getFilhoEsquerdo());
						// node.setFilhoDireito(node.getFilhoDireito().getFilhoDireito());
					}
				} else { // Caso C: o nodo node possui os dois filhos:
					aux = getMax(node.getFilhoEsquerdo(), node); // determina o maior da subárvore esquerda
					node.setValue(aux.getValue());
				}
				aux = null;
				return true; // fim dos casos em que o nó a eliminar foi encontrado, retornamos true
			} else { // se node não é o nó a eliminar, continuamos procurando recursivamente:
				if (compara(e, node.getValue()) < 0) { // se o objeto e for menor que o objeto em node, continuar
														// procurando à esquerda:
					return eliminar(node.getFilhoEsquerdo(), node, e); // chamada recursiva
				} else { // senão, procurar à direita:
					return eliminar(node.getFilhoDireito(), node, e); // chamada recursiva
				}
			}
		}
	}

	// searchABB(Object obj): método encarregado de chamar um outro método que
	// vai procurar um objeto "obj" na ABB a partir da raiz.
	public Node<E> searchABB(Object obj) {
		return searchABB(raiz, obj);
	}

	// searchABB(Node<E> node, Object obj): método que busca um elemento "obj"
	// na ABB a partir da raiz
	// e retorna o nó onde encontrou ou null se não encontrou o nodo
	private Node<E> searchABB(Node<E> node, Object obj) { // procura obj a partir do nó node
		// Se a raiz for nula (árvore vazia) ou chegou em uma folha => não achou o
		// objeto procurado:
		if (node == null) { // ou if (isEmpty())
			return null;
		} else {
			// Se achou o elemento, retornar o nó:
			if (((Comparable) obj).compareTo(node.getValue()) == 0) {
				return node;
			} else {
				// Se não achou, buscar recursivamente para a esquerda ou direita:
				if (((Comparable) obj).compareTo(node.getValue()) < 0) {
					return searchABB(node.getFilhoEsquerdo(), obj);
				} else {
					return searchABB(node.getFilhoDireito(), obj);
				}
			}
		}
	}

	/*
	 * Atividade: Parte I Solução possível para encontrar a quantidade de veículos
	 * com preço maior do que a média armazenado na árvore Serão necessários
	 * atributos específicos e métodos para resolver esta atividade. Sugestão:
	 * Utilizar algum método de percurso para resolver o solicitado. Caso tenha
	 * dúvidas, sugiro estudar o material da aula ao vivo ok!
	 * 
	 */
	public int qtdeMaiorMediaPrecos() {
		if (raiz == null) {
			return 0;
		}

		double soma = calcularSomaPrecos(raiz);
		int quantidade = getSize();

		if (quantidade == 0) {
			return 0;
		}

		double media = soma / quantidade;

		return contarAcimaDaMedia(raiz, media);
	}

	private double calcularSomaPrecos(Node<E> no) {
		if (no == null) {
			return 0;
		}
		Veiculo veiculo = (Veiculo) no.getValue();
		return veiculo.getPreco() + calcularSomaPrecos(no.getFilhoEsquerdo())
				+ calcularSomaPrecos(no.getFilhoDireito());
	}

	private int contarAcimaDaMedia(Node<E> no, double media) {
		if (no == null) {
			return 0;
		}
		Veiculo veiculo = (Veiculo) no.getValue();
		int count = veiculo.getPreco() > media ? 1 : 0;
		count += contarAcimaDaMedia(no.getFilhoEsquerdo(), media);
		count += contarAcimaDaMedia(no.getFilhoDireito(), media);
		return count;
	}

	/*
	 * Atividade: Parte II Solução possível para encontrar os veículos com ano de
	 * fabricação igual a "ano" e tipo igual a "tipo" passados como parâmetro. Deve
	 * retornar uma String contendo todos os veículos com essas características.
	 * Caso tenha dúvidas, sugiro estudar o material da aula ao vivo ok!
	 * 
	 */
	public String veiculosIgualAnoETipo(int ano, String tipo) {
	    StringBuilder resultado = new StringBuilder();
	    buscarAnoETipo(raiz, ano, tipo, resultado);
	    return resultado.toString();
	}

	// Método auxiliar para buscar veículos por ano e tipo
	private void buscarAnoETipo(Node<E> no, int ano, String tipo, StringBuilder resultado) {
	    if (no != null) {
	        buscarAnoETipo(no.getFilhoEsquerdo(), ano, tipo, resultado);
	        if (no.getValue() instanceof Veiculo) {
	            Veiculo veiculo = (Veiculo) no.getValue();
	            if (veiculo.getAno() == ano && veiculo.getTipo().equalsIgnoreCase(tipo)) {
	                resultado.append(veiculo.toString()).append("\n");
	            }
	        }
	        buscarAnoETipo(no.getFilhoDireito(), ano, tipo, resultado);
	    	}
	}
}
