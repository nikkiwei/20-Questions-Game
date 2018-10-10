package xmlreader;

import javax.xml.parsers.*;
import org.xml.sax.SAXException;  
import org.w3c.dom.*;
import java.io.*;

import datastructures.BinaryTree;
import datastructures.BinaryTreeNode;
import datastructures.DefaultBinaryTree;
import datastructures.DefaultBinaryTreeNode;

/**
 * Convert the xml tree into a decision tree
 * 
 * @author Nikki Wei
 * @version 1
 */

public class FileReader {
	
	/**
	 * Convert the xml file into a corresponding decision tree
	 * @param xmlFile the file to parse into the decision tree
	 * @return the decision tree represents the xml file
	 */
	public BinaryTree<String> readFile(File xmlFile) {
		
		//Setup XML Document and decision tree
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		BinaryTree<String> decisionTree = null;
		
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		try {
			Document document = builder.parse( xmlFile );
			decisionTree = parseFile(document);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return decisionTree;
	}
	
	/**
	 * Navigate through the major document structure
	 * @param doucment the document to be parsed
	 * @return a decision tree of the original file
	 */
	private static BinaryTree<String> parseFile(Document document) {
		Node docRoot = document.getDocumentElement();
		BinaryTree<String> decisionTree = new DefaultBinaryTree<String>();
		parseNode(docRoot, decisionTree);
		return decisionTree;
	}
	
	/**
	 * Parse every node in the xml tree into a decision Tree
	 * @param n the current node in xml tree
	 * @param decisionTree the binary search tree of the questions
	 */
	private static void parseNode(Node n, BinaryTree<String> decisionTree) {
		
		// check if the current node is an element node
		if( n.getNodeType() == Node.ELEMENT_NODE ) {	
			
			Element currentElt = (Element)n;

			BinaryTreeNode<String> newNode = parseElement(currentElt);

			// if the question node has attribute "root", it is the root of the tree
			if (!currentElt.hasAttribute("root")) {
				decisionTree.setRoot(newNode);
			}
		}
	}
	
	/**
	 * Parse an element node of xml tree into a binary tree node
	 * Recursively alled on all nodes in the document, as well as all nodes that a particular node has
	 * @param element element node
	 * @return a BinaryTreeNode
	 */
	private static BinaryTreeNode<String> parseElement(Element element) {
		
		// variables needed to initialize a new binary tree node
		String data = "";
		BinaryTreeNode<String> left = null;
		BinaryTreeNode<String> right = null;
		BinaryTreeNode<String> node = new DefaultBinaryTreeNode<String>();
		
		// base case
		if (!element.hasChildNodes()) {
			return null;
		}

		// recursive case
		else {
			
			// loop through all the child nodes
			NodeList children = element.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				
				// only deal with element nodes
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {

					Element childElt = (Element) children.item(i);

					// when we encounter a question node, get the question text
					if (childElt.getNodeName().equals("question")) {
						data = childElt.getTextContent();
					}

					// when we encounter an answer node
					else if (childElt.getNodeName().equals("answer")){

						// if the answer is yes, go to left
						if (childElt.getAttribute("id").equals("Yes")) {
							left = parseElement(childElt);
						}

						// if the answer is no, go to right
						else if (childElt.getAttribute("id").equals("No")) {
							right = parseElement(childElt);
						}
					}
				}
			}
			
			// initialize the node
			node.setData(data);	
			node.setLeftChild(left);
			node.setRightChild(right);
		}
		
		return node;
	}
}
