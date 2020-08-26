# -*- coding: utf-8 -*-
"""
Created on Mon Oct 14 15:10:45 2019

@author: Saúl Lázaro
"""
import random
import os
import itertools
from ficheros import FICHEROSOLUCION#variables con los datos de los ficheros

'''Clase Carta'''
class Carta:
    palo = ''#Or(oros), Es(espadas),Co(Copas),Ba(bastos)
    numero = 1
    
    '''#constructor de la clase'''
    def __init__(self,palo,numero):
        self.palo = palo
        self.numero = numero
        return
    
    ''' Pintamos primero el número de la carta y luego el palo.Ej 1Or(uno de Oros) 2Or, 3Ba
    Recibe un booleano para indicar si hay q pintar por pantalla o devolverlo en un string
    '''
    def pintar_carta(self,fichero):        
        if fichero == False:
            if(self.numero==8):
                print("Sota de ",self.palo)
            elif(self.numero==9):
                print("Caballo de ",self.palo)
            elif(self.numero==10):
                print("Rey de ",self.palo)
            else:
                print(self.numero," de ",self.palo)
        else:
            cadena =""
            if(self.numero==8):
                cadena += "Sota de " + str(self.palo) +"."
            elif(self.numero==9):
                cadena += "Caballo de " + str(self.palo) +"."
            elif(self.numero==10):
                cadena += "Rey de " + str(self.palo) +"."
            else:
                cadena += str(self.numero) + " de " +self.palo +"."
            return cadena
        
    '''Retorna el valor de la carta'''
    def Recuperar_valor(self):
        if((self.numero==8) or (self.numero==9) or(self.numero==10)):
            return 0.5
        else:
            return self.numero
        
'''Clase Baraja:
atributos:
    numero_cartas
    lista_cartas --> para simular las cartas de una baraja
    dic_coluciones--> diccionario de lista de cartas que almacena las soluciones'''   
class Baraja:
    numero_cartas = 0#numero de cartas de la baraja
    lista_cartas = [] #lista de cartas
    dic_soluciones = {}#diccionario de soluciones
    
    '''Constructor de la clase Baraja.
    Inicializa la baraja, crea 40 cartas. Los valores 8,9 y 10 los tomaremos como si fuesen, sotas
    caballos y reyes respectivamente'''
    def __init__(self):
        self.numero_cartas = 40
        j=1
        for i in range(1,41):
            if i<=10:
                #Oros
                self.lista_cartas.append(Carta('Oros',j))                
            elif(i>10 and i<=20):
                #espadas
                self.lista_cartas.append(Carta('Espadas',j))
            elif(i>20 and i<=30):
                #copas
                self.lista_cartas.append(Carta('Copas',j))
            else:
                #bastos
                self.lista_cartas.append(Carta('Bastos',j))            
            if j==10:
                j=1;
            else:
                j += 1
                
    '''Recorre toda la baraja y pinta cada una de las cartas'''                
    def PintarBaraja(self):
        for i in self.lista_cartas:
            i.pintar_carta(False)#Le indicamos false para que lo pinte en pantalla
            
    '''Vuelva las soluciones en un fichero .txt'''            
    def PintarSoluciones(self):  
        #Pinta las soluciones en pantalla y las guarda en un fichero.
        fichero = open(FICHEROSOLUCION, "w")
        print("SOLUCIONES: ")
        cadena =""
        cadena += "TOTAL SOLUCIONES: " + str(len(self.dic_soluciones)) 
        fichero.write(cadena + os.linesep)
        for key,values in self.dic_soluciones.items():                        
            cadena =""
            print("Solución",key,":")   
            cadena += "Solución" + str(key)  + ":("    
            for j in values:
                j.pintar_carta(False)
                cadena += str(j.pintar_carta(True))
            fichero.write(cadena +")"+ os.linesep)
        fichero.close()    
        
    '''Mezcla la baraja'''       
    def Barajar(self):
        random.shuffle(self.lista_cartas)
        
    '''Añade una nueva lista de cartas al diccionario de soluciones si esa lista todavía no ha sido añadida como solución'''
    def AddSolucion(self,lista,carta):
        lvalores = self.dic_soluciones.keys()#recuperamos el total de soluciones        
        clave=len(lvalores) + 1#añadimos 1 a la clave
        lc = lista.copy()              
        lista_valores =self.dic_soluciones.values()#devolvemos las soluciones almacenadas
        lc.append(carta)#añadimos la carta a la lista de soluciones
        if lc not in lista_valores:#si la lista de cartas no está en la lista de soluciones, entonces la añadimos            
            self.dic_soluciones[clave]=lc#añadimos la lista de cartas al diccionario de soluciones totales
            
    '''Suma los valores de las cartas almacenadas en la lista.
    Retorna el valor de la suma de todas las cartas'''            
    def SumarValores(self,lista):
        total = 0
        for i in lista:
            total += i.Recuperar_valor()#para cada carta, recupero su valor
        return total
    
    def BuscarRecursivo(self,indice,lista_sele):
        #una vez que llegamos al final de la lista, dejamos de buscar
        if(indice <len(self.lista_cartas)):            
            c= self.lista_cartas[indice]
            if(self.SumarValores(lista_sele) + c.Recuperar_valor() == 7.5 ):
                #es solución. Añadimos la lista de cartas al diccionario de soluciones
                lis_cop = lista_sele.copy()#copiamos la lista para seguir buscando mas soluciones sin la última carta
                self.AddSolucion(lista_sele,c)                
                self.BuscarRecursivo(indice+1,lis_cop)#pasamos la lista sin la última carta
            elif(self.SumarValores(lista_sele) + c.Recuperar_valor() < 7.5 ):
                #hay que seguir buscando. Añado la carta a la lista y sigo mirando cartas
                lista_sele.append(c)
                self.BuscarRecursivo(indice+1,lista_sele)
            else:
                #no es solución
                self.BuscarRecursivo(indice+1,lista_sele)
        
    def BuscarSoluciones(self):
        i=0
        lista_selecionadas = []#cartas que vamos seleccionando
        for i in range(0,len(self.lista_cartas)):
            c= self.lista_cartas[i]
            lista_selecionadas.append(c)#añadimos la carta elegida a la lista de seleccionadas
            i += 1 #incrementamos el indice para buscar a partir de la carta seleccionada
            self.BuscarRecursivo(i,lista_selecionadas)#llamamos al método recursivo para buscar todas las soluciones con la carta elegida
            lista_selecionadas.clear()#limpiamos la lista de seleccionadas
            
    '''Genera todos los subconjuntos de de 2 a 13 cartas(no puede haber más de 13 cartas que sumen 7,5)
    De los conjuntos generados, guardamos aquellos que suman 7,5 y que no han sido guardados'''
    def BuscarSolucionesConjuntos(self):
        li = []
        lis_com = []#lista para comprobar repetidos        
        y=1
        for j in range(2,4):#Numeros de 2 a 13 
            for x in itertools.combinations(self.lista_cartas,j):#Genera subconjuntos de carta de j elementos
                li = x#lista de cartas generado, lo almacenamos en una lista
                if self.SumarValores(li) == 7.5:#suma los valores de la lista de cartas li
                    if li not in lis_com:#si la lista no ha sido añadida como solución
                        lis_com.append(li)#añadimos la nueva lista de cartas que suman 7,5                        
                        self.dic_soluciones[y]= li#almacenamos en la estructura de soluciones la nueva solución
                        y += 1   
        
#Prueba programa siete y media
espa = Baraja()#Instancio un objeto de tipo Baraja
'''c1 = Carta("Oros",3)
c2 = Carta("Espadas",10)
print("Baraja Inicial: ")
print("------------------------------------")
espa.PintarBaraja()
print("\n")'''
espa.Barajar()
print("Baraja mezclada: ")
print("------------------------------------")
espa.PintarBaraja()
espa.BuscarSoluciones()
#espa.BuscarSolucionesConjuntos()
espa.PintarSoluciones()




